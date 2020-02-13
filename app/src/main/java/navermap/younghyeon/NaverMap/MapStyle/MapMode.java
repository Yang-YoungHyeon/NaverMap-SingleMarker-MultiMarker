package navermap.younghyeon.NaverMap.MapStyle;

/** 맵의 모드를 정할 때 사용하는 클래스 [굳이 이 클래스를 안써도 되지만, 어떤 모드들이 있는지 확인하기 좋음]
 *  Date. 2020.02.13
 *  Creator. 양영현
 * */
import com.naver.maps.map.NaverMap;

public class MapMode {
    /** 해당 클래스는 생성자를 사용할 수 없음 */
    private MapMode(){}

    //실내지도 : 줌레벨이 일정수준이상일 때 실내지도를 표시함 (Basic, Terrain 만 지원함)
    public void setIndoorEnable(NaverMap naverMap, boolean bool){
        if(naverMap.getMapType().equals(NaverMap.MapType.Basic) || naverMap.getMapType().equals(NaverMap.MapType.Terrain)){
            naverMap.setIndoorEnabled(bool);
        }
    }
    //야간지도 : 지도의 스타일이 어두운 톤으로 바뀜 ( Navi 만 지원함)
    public void setNightModeEnable(NaverMap naverMap, boolean bool){
        if(naverMap.getMapType().equals(NaverMap.MapType.Navi)){
            naverMap.setNightModeEnabled(bool);
        }
    }
    //라이트모드 : 지도의 로딩이 빨라지고, 메모리 소모가 줄지만 많은 제약이 생김 ( 따라서 현재는 쓰지 않을 것임)
    public void setLiteModeEnable(NaverMap naverMap, boolean bool){
        if(!naverMap.getMapType().equals(NaverMap.MapType.Navi)){
            naverMap.setLiteModeEnabled(false); //사용하지 않을 것임.
        }
    }

}
