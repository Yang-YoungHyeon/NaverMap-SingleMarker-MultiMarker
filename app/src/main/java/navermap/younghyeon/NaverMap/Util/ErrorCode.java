package navermap.younghyeon.NaverMap.Util;

import android.content.Context;

import navermap.younghyeon.R;

/** 에러코드에 따라 대응되는 문자열 값 반환하는 클래스
 *  Date. 2020.02.13
 *  Creator. 양영현
 *  */

public class ErrorCode {
    /** 해당 클래스는 생성자를 사용할 수 없음 */
    private ErrorCode(){}

    /** 에러코드를 대응 문자열로 반환 */
    public static String getErrorType(Context context, String errorCode) {
        int err = Integer.parseInt(errorCode);
        switch (err) {
            case 401 :
                //잘못된 클라이언트 ID를 지정, 잘못된 클라이언트 유형을 사용, 콘솔에서 앱 패키지 이름을 잘못 등록 or 미등록
                return context.getString(R.string.ERROR401);
            case 429 :
                //콘솔에서 Maps 서비스를 선택하지 않음, 사용한도가 초과됨
                return context.getString(R.string.ERROR429);
            case 800 :
                //클라이언트 ID를 지정하지 않음
                return context.getString(R.string.ERROR800);
            default:
                //위에 정해진 에러코드가 아닌경우 해당 에러코드값만 반환
                return errorCode+"";
        }
    }
}
