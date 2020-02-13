package navermap.younghyeon.NaverMap.MapStyle;

import com.naver.maps.map.NaverMap;
/** 맵의 그룹을 정할 때 사용하는 클래스 [굳이 이 클래스를 안써도 되지만, 어떤 그룹들이 있는지 확인하기 좋음]
 *  Date. 2020.02.13
 *  Creator. 양영현
 * */
public class GroupType {
    /** 해당 클래스는 생성자를 사용할 수 없음 */
    private GroupType(){}

    //건물형상,주소심벌등 관련된 기본요소 출력, 기본적으로 true 상태
    // MapType 이 Satellite라면, 해당 그룹을 사용할 수 없음.
    public static void onGroupBilding(NaverMap naverMap, boolean bool){
        if(!naverMap.getMapType().equals(NaverMap.MapType.Satellite)){
            naverMap.setLayerGroupEnabled(NaverMap.LAYER_GROUP_BUILDING,bool);
        }
    }
    //실시간 교통정보 그룹, 활성화할 경우 실시간 교통정보가 노출됨
    public static void onGroupTraffic(NaverMap naverMap, boolean bool){
        naverMap.setLayerGroupEnabled(NaverMap.LAYER_GROUP_TRAFFIC,bool);
    }
    //대중교통 그룹, 활성화할 경우 철도,지하철 노선, 버스정류장 등 대중교통과 관련된 요소가 노출됨
    // MapType 이 Navi라면, 해당 그룹을 사용할 수 없음.
    public static void onGroupTransit(NaverMap naverMap, boolean bool){
        if(!naverMap.getMapType().equals(NaverMap.MapType.Navi)){
            naverMap.setLayerGroupEnabled(NaverMap.LAYER_GROUP_TRANSIT,bool);
        }
    }
    //자전거 그룹, 활성화할 경우 자전거 도로, 자전거 주차대 등 자전거과 관련된 요소가 출력됨
    // MapType 이 Navi라면, 해당 그룹을 사용할 수 없음.
    public static void onGroupBicycle(NaverMap naverMap, boolean bool){
        if(!naverMap.getMapType().equals(NaverMap.MapType.Navi)){
            naverMap.setLayerGroupEnabled(NaverMap.LAYER_GROUP_BICYCLE,bool);
        }
    }
    //등산로 그룹, 활성화할 경우 등산로, 등고선 등 등산과 관련된 요소가 노출됨
    // MapType 이 Navi라면, 해당 그룹을 사용할 수 없음.
    public static void onGroupMountain(NaverMap naverMap, boolean bool){
        if(!naverMap.getMapType().equals(NaverMap.MapType.Navi)){
            naverMap.setLayerGroupEnabled(NaverMap.LAYER_GROUP_MOUNTAIN,bool);
        }
    }
    //지적편집도 그룹, 활성화할 경우 지적편집도가 노출됨
    // MapType 이 Navi라면, 해당 그룹을 사용할 수 없음.
    public static void onGroupCadastral(NaverMap naverMap, boolean bool){
        if(!naverMap.getMapType().equals(NaverMap.MapType.Navi)){
            naverMap.setLayerGroupEnabled(NaverMap.LAYER_GROUP_CADASTRAL,bool);
        }
    }
}
