package navermap.younghyeon;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraAnimation;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapSdk;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.util.MarkerIcons;

import java.util.LinkedList;

import navermap.younghyeon.NaverMap.Util.ErrorCode;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{
    EditText etLat; //위도 에딧
    EditText etLng; //경도 에딧

    NaverMap mNaverMap; //네이버 맵
    Marker mOneMarker; //스마트폰 자체의 위치, 검색된 위치 등을 표시할 때 사용
    LinkedList<Marker> mDrawMarkerList; //여러개의 위치를 동시에 표시할 때 사용
    LinkedList<Marker> mClearMarkerList; //여러개의 위치를 동시에 지워야 할 때 사용

    /** MainActivity 가 호출되어 생명주기상 onCreate 부분에 실행할 내용을 이곳에 작성 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onErrorResult();
        setFragment();
        etLat = findViewById(R.id.et_Lat);
        etLng = findViewById(R.id.et_Lng);
        mDrawMarkerList = new LinkedList<>();
        mClearMarkerList = new LinkedList<>();
        findViewById(R.id.btn_Search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etLat.getText().toString().length()!=0 && etLng.getText().toString().length()!=0){
                    try{
                        Double lat = Double.parseDouble(etLat.getText().toString());
                        Double lng = Double.parseDouble(etLng.getText().toString());
                        drawMarker(lat,lng);
                    }catch (Exception e){
                        Toast.makeText(MainActivity.this, "위도,경도가 잘못되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    /** 1개의 좌표로 이동하여 마커 찍는 메소드 */
    private void drawMarker(double lat, double lng){
        LatLng latLng = new LatLng(lat,lng);
        mOneMarker.setMap(null);
        mOneMarker.setPosition(latLng);
        mOneMarker.setCaptionText("Title");
        mOneMarker.setCaptionColor(Color.RED);
        mOneMarker.setSubCaptionText("sub Title");
        mOneMarker.setSubCaptionColor(Color.BLUE);
        mOneMarker.setIcon(MarkerIcons.BLACK);
        mOneMarker.setIconTintColor(Color.GREEN);
        mOneMarker.setMap(mNaverMap);
        CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(latLng,18).animate(CameraAnimation.Fly);
        mNaverMap.moveCamera(cameraUpdate);
    }
    /** 여러개 찍어야할 때 리스트에 담는 메소드 */
    private void addMarker(Marker marker){
        mDrawMarkerList.add(marker);
    }
    /** 여러개의 좌표로 마커를 찍는 메소드 */
    private void drawMarkerList(){
        clearMarkerList();
        for(Marker m : mDrawMarkerList){
            m.setMap(mNaverMap);
            mClearMarkerList.add(m);
        }
        mDrawMarkerList.clear();
    }
    /** 이전 마커들을 지우는 메소드 */
    private void clearMarkerList(){
        for(Marker m : mClearMarkerList){
            m.setMap(null);
        }
        mClearMarkerList.clear();
    }

    /** 네이버 맵 프레그먼트를 이곳에 작성 */
    private void setFragment(){
        FragmentManager fm = getSupportFragmentManager();
        MapFragment mapFragment = (MapFragment)fm.findFragmentById(R.id.map);
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            fm.beginTransaction().add(R.id.map, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);
    }

    /** 맵을 성공적으로 처음 호출했을 때 설정할 내용을 이곳에 작성 */
    @UiThread
    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        this.mNaverMap = naverMap;
        mOneMarker = new Marker();
        mOneMarker.setPosition(new LatLng(37.566676,126.978414));
        mOneMarker.setCaptionText("Title");
        mOneMarker.setCaptionColor(Color.RED);
        mOneMarker.setSubCaptionText("sub Title");
        mOneMarker.setSubCaptionColor(Color.BLUE);
        mOneMarker.setIcon(MarkerIcons.BLACK);
        mOneMarker.setIconTintColor(Color.GREEN);
        mOneMarker.setMap(mNaverMap);
    }

    /** 맵을 호출하려는데 발생하는 에러에 대한 처리 내용을 이곳에 작성 */
    private void onErrorResult(){
        NaverMapSdk.getInstance(this).setOnAuthFailedListener(new NaverMapSdk.OnAuthFailedListener(){
            @Override
            public void onAuthFailed(@NonNull NaverMapSdk.AuthFailedException e) {
                /* 처리 내용은 이곳에 작성 */
                Context mContext = MainActivity.this;
                Toast.makeText(mContext,
                        ""+ ErrorCode.getErrorType(mContext, e.getErrorCode()),
                        Toast.LENGTH_LONG).show();
            }
        } );
    }
}