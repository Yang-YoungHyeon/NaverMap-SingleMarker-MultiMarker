package navermap.younghyeon.NaverMap.MapStyle;

import com.naver.maps.map.NaverMap;
/** 맵의 타입을 정할 때 사용하는 클래스 [굳이 이 클래스를 안써도 되지만, 어떤 타입들이 있는지 확인하기 좋음]
 *  Date. 2020.02.13
 *  Creator. 양영현
 * */
public class MapType {
    /** 해당 클래스는 생성자를 사용할 수 없음 */
    private MapType(){}

    //일반지도로 설정
    public static void setMapBasic(NaverMap naverMap){
        naverMap.setMapType(NaverMap.MapType.Basic);
    }
    //차량용 내비게이션에 특화된 지도로 설정
    public static void setMapNavi(NaverMap naverMap){
        naverMap.setMapType(NaverMap.MapType.Navi);
    }
    //위성지도. 위성사진을 제외한 나머지는 노출하지 않음
    public static void setMapSatellite(NaverMap naverMap){
        naverMap.setMapType(NaverMap.MapType.Satellite);
    }
    //위성사진과 도로, 심벌을 함께 출력하는 하이브리드 지도
    public static void setMapHybrid(NaverMap naverMap){
        naverMap.setMapType(NaverMap.MapType.Hybrid);
    }
    //지형도. 산악지형을 실제유형과 유사하게 입체적으로 표현
    public static void setMapTerrain(NaverMap naverMap){
        naverMap.setMapType(NaverMap.MapType.Terrain);
    }
}
