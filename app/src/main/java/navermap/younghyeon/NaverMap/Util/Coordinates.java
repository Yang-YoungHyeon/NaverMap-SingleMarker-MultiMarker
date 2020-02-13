package navermap.younghyeon.NaverMap.Util;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.geometry.Tm128;
import com.naver.maps.geometry.Utmk;

/** 네이버 MAP 에서 사용하는 3가지 좌표계간 변환 [ 1가지의 좌표계로 앱을 만들경우 굳이 안사용해도 되는 클래스 ]
 *  Date. 2020.02.13
 *  Creator. 양영현
 *  */

public class Coordinates {
    /** 해당 클래스는 생성자를 사용할 수 없음 */
    private Coordinates(){}

    /** Utmk 좌표계를 LatLng 좌표로 변환 */
    public static LatLng UtmkToLatLng(Utmk utmk){
        return utmk.toLatLng();
    }
    /** Tm128 좌표계를 LatLng 좌표로 변환 */
    public static LatLng Tm128ToLatLng(Tm128 tm128){
        return tm128.toLatLng();
    }
    /** LatLng 좌표계를 Utmk 좌표로 변환 */
    public static Utmk LatLngToUtmk(LatLng latLng){
        return Utmk.valueOf(latLng);
    }
    /** Tm128 좌표계를 Utmk 좌표로 변환 */
    public static Utmk Tm128ToUtmk(Tm128 tm128){
        return Utmk.valueOf(tm128.toLatLng());
    }
    /** Utmk 좌표계를 Tm128 좌표로 변환 */
    public static Tm128 UtmkToTm128(Utmk utmk){
        return Tm128.valueOf(utmk.toLatLng());
    }
    /** LatLng 좌표계를 Tm128 좌표로 변환 */
    public static Tm128 LatLngToTm128(LatLng latLng){
        return Tm128.valueOf(latLng);
    }
}
