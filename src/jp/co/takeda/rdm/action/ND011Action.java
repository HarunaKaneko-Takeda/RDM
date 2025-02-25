/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import jp.co.takeda.rdm.dto.NC101DTO;
import jp.co.takeda.rdm.common.BaseAction;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.ND011DTO;
import jp.co.takeda.rdm.service.ND011Service;
import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;
import lombok.Getter;
import lombok.Setter;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

/**
 * Actionクラス
 * @generated
 */
@Named("nD011Action")
@Scope("request")
public class ND011Action extends BaseAction<ND011DTO> {

    /**
     * シリアルバージョンID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * Serviceオブジェクト
     * @generated
     */
    @Inject
    private ND011Service nD011Service;
    // 確認画面用にする
    private NC101DTO paramDto;
    // START UOC
    // END UOC

    /**
     * コンストラクタ
     * @generated
     */
    public ND011Action() {
        dto = new ND011DTO();
    }

    /**
     * イベント毎のメソッド実行前に共通後処理。<br/>
     * 但し、validationエラー時は実行されない。
     * @return 遷移先（nullの場合、イベントのメソッドを呼び出す）
     * @customizable
     */
    @Before
    public String before() throws Exception {
        // START UOC
        return null;
        // END UOC
        // START UOC
    }

    /**
     * イベント毎のメソッド実行前に共通後処理。<br/>
     * 但し、validationエラー時は実行されない。
     * @customizable
     */
    @BeforeResult
    public void beforeResult() throws Exception {
        // START UOC

        // END UOC
    }

    /**
     * validationエラー時に実行する処理。<br/>
     * @customizable
     */
    @InputConfig
    public String validationError() {
        // START UOC
        return "input";
        // END UOC
    }
    /**
     * 業務処理
     * @customizable
     */
    public String init() throws Exception {
        initSetup();
        // F層呼び出し
        BaseDTO outdto = nD011Service.init(dto);
        return initNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void initSetup() throws Exception {
        // START UOC
        LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

    	//改ページ設定
        dto.setPageCntCur(1);

//        // 登録完了画面から戻る場合、遷移前の検索条件をセッションから取得する。
//        //　遷移元画面IDを取得
//        String finishFlg = (String)request.getParameter(RdmConstantsData.NC101_FINISH_FLG);
//        // 遷移元画面が登録完了画面の場合
//        if (RdmConstantsData.NC101_FINISH_VALUE.equals(finishFlg)) {
//            ND011DTO searchKey = (ND011DTO)sessionMap.get(AppConstant.SESKEY_ND011_SEARCHKEY);
//            BeanUtils.copyProperties(dto, searchKey);
//
//        } else if (!dto.getBackScreenId().startsWith("JKR030C0")) {
//            //前画面から組織関連パラメータ設定
//            setSosInfo(sessionMap, dto);
//        }

//        dto.setStatus("FirstTab");

//        dto.setActionMtKbn("1");
      //画面タイト制御処理
        String title = "ND011_医師新規作成";
        //ユーザ権限
        String jokenSetCd = dto.getLoginJokenSetCd();

        dto.setTitle(title);

        String preScreenId = loginInfo.getPreScreenId();
        String reqId = dto.getReqId();
        String ultCd = dto.getUltDocCd();

        //モック
        preScreenId = "NC011";

        // 遷移パターン　0:完全新規、1:ULTから作成、2：申請データあり
        // ULTT医師コード　ありなしで分岐
        // ND001_医師検索
        if ("ND001".equals(preScreenId)) {
        	if (ultCd != null && ultCd.length() > 0) {
        		// ULT医師コードで初期データ作成
        		dto.setDisplayKbn("1");
        	} else if(ultCd == null || ultCd.length() == 0){
        		// 完全新規
        		dto.setDisplayKbn("0");
        	} else { //遷移エラー
        	}
        }
        // 申請ID
        // NC011_申請一覧
        // ND301_医師新規作成 - 申請内容確認
        // NM101_通知内容詳細
        if ("NC011".equals(preScreenId) || "ND301".equals(preScreenId) || "NM101".equals(preScreenId)) {
        	if (reqId != null && reqId.length() > 0) {
        		// 申請データ（一時保存含む）を参照
        		dto.setDisplayKbn("2");
        	} else { //遷移エラー
        	}
        }

        dto.setMsgId(null);

        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String initNext(BaseDTO outdto) throws Exception {
        // START UOC
        // 検索条件をセッションに格納する（リンク押下時に使用）
        sessionMap.put(AppConstant.SESKEY_ND011_SEARCHKEY, outdto);
        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 業務処理
     * @customizable
     */
    @InputConfig(methodName="validationError")
    public String register() throws Exception {
        registerSetup();
        // F層呼び出し
        BaseDTO outdto = nD011Service.register(dto);
        if (outdto instanceof ND011DTO) {
            // START UOC
            outdto = nD011Service.register(dto);
            // END UOC
        }
        return registerNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void registerSetup() throws Exception {
        // START UOC
        dto.setMsgId(null);
        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String registerNext(BaseDTO outdto) throws Exception {
        // START UOC
        if (!RdmConstantsData.M0122740.equals(StringUtils.nvl(dto.getMsgId(),""))
                && !RdmConstantsData.M0001102.equals(StringUtils.nvl(dto.getMsgId(),""))
                && !RdmConstantsData.M0001101.equals(StringUtils.nvl(dto.getMsgId(),""))
                && !"exception".equals(outdto.getForward())){
            setJumpInfo(dto.getMsgId());
            outdto.setForward("NC101Init");
        }
        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

//    /**
//     * 業務処理
//     * @customizable
//     */
//    @InputConfig(methodName="validationError")
//    public String downLoad() throws Exception {
//        downLoadSetup();
//        // F層呼び出し
//        BaseDTO outdto = nD011Service.downLoad(dto);
//        return downLoadNext(outdto);
//    }

//    /**
//     * 前処理
//     * @customizable
//     */
//    protected void downLoadSetup() throws Exception {
//        // START UOC
//
//        // END UOC
//    }
//
//    /**
//     * 後処理
//     * @customizable
//     */
//    protected String downLoadNext(BaseDTO outdto) throws Exception {
//        // START UOC
//        outdto.setForward("stream");
//        // END UOC
//        setNextDTO(outdto);
//        return outdto.getForward();
//    }

//    /**
//     * 業務処理
//     * @customizable
//     */
//    @InputConfig(methodName="validationError")
//    public String sort() throws Exception {
//        sortSetup();
//        // F層呼び出し
//        BaseDTO outdto = nD011Service.sort(dto);
//        if (outdto instanceof ND011DTO) {
//            // START UOC
//
//            // END UOC
//        }
//        return sortNext(outdto);
//    }

//    /**
//     * 前処理
//     * @customizable
//     */
//    protected void sortSetup() throws Exception {
//        // START UOC
//
//        // END UOC
//    }
//
//    /**
//     * 後処理
//     * @customizable
//     */
//    protected String sortNext(BaseDTO outdto) throws Exception {
//        // START UOC
//        // 検索条件をセッションに格納する（リンク押下時に使用）
//        sessionMap.put(AppConstant.SESKEY_ND011_SEARCHKEY, outdto);
//        // END UOC
//        setNextDTO(outdto);
//        return outdto.getForward();
//    }


//    /**
//     * 業務処理
//     * @customizable
//     */
//    @InputConfig(methodName="validationError")
//    public String page() throws Exception {
//        pageSetup();
//        // F層呼び出し
//        BaseDTO outdto = nD011Service.page(dto);
//        if (outdto instanceof ND011DTO) {
//            // START UOC
//
//            // END UOC
//        }
//        return pageNext(outdto);
//    }

//    /**
//     * 前処理
//     * @customizable
//     */
//    protected void pageSetup() throws Exception {
//        // START UOC
//
//        // END UOC
//    }
//
//    /**
//     * 後処理
//     * @customizable
//     */
//    protected String pageNext(BaseDTO outdto) throws Exception {
//        // START UOC
//        // 検索条件をセッションに格納する（リンク押下時に使用）
//        sessionMap.put(AppConstant.SESKEY_ND011_SEARCHKEY, outdto);
//        // END UOC
//        setNextDTO(outdto);
//        return outdto.getForward();
//    }

    // START UOC
    /**
     * 終了画面へ遷移用パラメータ設定。
     * @param dto 登録完了画面DTO
     * @param msgId メッセージID
     */
    private void setJumpInfo(String msgId) {
        // メッセージオブジェクト取得
        LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

        String subTitle = "";
        String jokenSetCd = dto.getLoginJokenSetCd();

        //画面タイトル内容設定
        paramDto = new NC101DTO();
        // ブラウザタイトル
        paramDto.setBrowerTitle ("担当引継ぎ"+ subTitle);
        // 画面タイトル
        paramDto.setTitle("担当引継ぎ"+ subTitle);
        // 戻るリンク(表示文言)
        paramDto.setReturnLinkNm1("戻る");
        // 戻るリンク(遷移先URL)
        paramDto.setReturnLinkURL1("ND011Init");
        // メッセージ１
        paramDto.setMessage1(loginInfo.getMsgEntity(RdmConstantsData.I0122706));
        paramDto.setMessage3(loginInfo.getMsgEntity(msgId));

        ND011DTO searchKey = (ND011DTO)sessionMap.get(AppConstant.SESKEY_ND011_SEARCHKEY);
//        searchKey.setActionMtKbn("2");
        sessionMap.put(AppConstant.SESKEY_ND011_SEARCHKEY, searchKey);
    }

    /**
     * 前画面から組織関連パラメータ設定
     * @param Dto010
     */
    public void setSosInfo(Map<String, Object> sessionMap, ND011DTO Dto010) {

//        //トップメニューで組織(現)を選択した場合
//        if ("0".equals(Dto010.getSosSelFlg())) {
//
//            // 検索条件_組織・担当（新）_テキスト
//            Dto010.setDispToSosJgiName("");
//            // 検索条件_新組織コード
//            Dto010.setSearchToSosCd("");
//            // 検索条件_組織（新）_テキスト
//            Dto010.setSearchToSosName("");
//            //検索条件_組織コード（新）（営業所）
//            Dto010.setSearchToSosCd3("");
//
//
//        //トップメニューで組織(新)を選択した場合
//        } else {
//
//            // 検索条件_組織・担当（現）_テキスト
//            Dto010.setDispFromSosJgiName("");
//            // 検索条件_現組織コード
//            Dto010.setSearchFromSosCd("");
//            // 検索条件_組織（現）_テキスト
//            Dto010.setSearchFromSosName("");
//            // 検索条件_現組織支店コード
//            Dto010.setSearchFromSosCd2("");
//            // 検索条件_現組織支店名称
//            Dto010.setSearchFromSosNm2("");
//            // 検索条件_現組織の組織コード３
//            Dto010.setSearchFromSosCd3("");
//            // 検索条件_現組織の組織コード４
//            Dto010.setSearchFromSosCd4("");
//        }
//
//        // 検索条件_現従業員番号
//        Dto010.setSearchFromJgiNo("");
//        // 検索条件_現従業員
//        Dto010.setSearchFromJgiName("");
//        // 検索条件_新従業員番号
//        Dto010.setSearchToJgiNo("");
//        // 検索条件_新従業員
//        Dto010.setSearchToJgiName("");

       if ((Dto010.getBackScreenId().startsWith("JKR040C0") || Dto010.getBackScreenId().startsWith("JKR050C0"))
//            && !StringUtils.isEmpty(Dto010.getTopChangedSosCd())
            ) {

//            //トップメニューで組織(現)を選択した場合
//            if ("0".equals(Dto010.getSosSelFlg())) {
//                // 検索条件_組織・担当（現）_テキスト
//                Dto010.setDispFromSosJgiName(Dto010.getTopChangedSosNm());
//                // 検索条件_現組織コード
//                Dto010.setSearchFromSosCd(Dto010.getTopChangedSosCd());
//                // 検索条件_組織（現）_テキスト
//                Dto010.setSearchFromSosName(Dto010.getTopChangedSosNm());
//                // 検索条件_現組織支店コード
//                Dto010.setSearchFromSosCd2(Dto010.getTopChangedSosCd2());
//                // 検索条件_現組織支店名称
//                Dto010.setSearchFromSosNm2(Dto010.getTopChangedSosNm2());
//                // 検索条件_現組織の組織コード３
//                Dto010.setSearchFromSosCd3(Dto010.getTopChangedSosCd3());
//                // 検索条件_現組織の組織コード４
//                Dto010.setSearchFromSosCd4("");
//
//            //トップメニューで組織(新)を選択した場合
//            } else {
//
//                // 検索条件_組織・担当（新）_テキスト
//                Dto010.setDispToSosJgiName(Dto010.getTopChangedSosNm());
//                // 検索条件_新組織コード
//                Dto010.setSearchToSosCd(Dto010.getTopChangedSosCd());
//                // 検索条件_組織（新）_テキスト
//                Dto010.setSearchToSosName(Dto010.getTopChangedSosNm());
//                //検索条件_組織コード（新）（営業所）
//                Dto010.setSearchToSosCd3(Dto010.getTopChangedSosCd3());
//
//            }
        } else {

//            //トップメニューで組織(現)を選択した場合
//            if ("0".equals(Dto010.getSosSelFlg())) {
//                // 検索条件_現組織コード
//                Dto010.setSearchFromSosCd(Dto010.getSelectedSosCd());
//                // 検索条件_組織・担当（現）_テキスト
//                Dto010.setDispFromSosJgiName(Dto010.getSelectedSosNm());
//                // 検索条件_組織（現）_テキスト
//                Dto010.setSearchFromSosName(Dto010.getSelectedSosNm());
//                // 検索条件_現組織支店コード
//                Dto010.setSearchFromSosCd2(Dto010.getSelectedSosCd2());
//                // 検索条件_現組織支店名称
//                Dto010.setSearchFromSosNm2(Dto010.getSelectedSosNm2());
//                // 検索条件_現組織の組織コード３
//                Dto010.setSearchFromSosCd3(Dto010.getSelectedSosCd3());
//                // 検索条件_現組織の組織コード４
//                Dto010.setSearchFromSosCd4("");
//
//            //トップメニューで組織(新)を選択した場合
//            } else {
//
//                // 検索条件_新組織コード
//                Dto010.setSearchToSosCd(Dto010.getSelectedSosCd());
//                // 検索条件_組織・担当（新）_テキスト
//                Dto010.setDispToSosJgiName(Dto010.getSelectedSosNm());
//                // 検索条件_組織（新）_テキスト
//                Dto010.setSearchToSosName(Dto010.getSelectedSosNm());
//                // 検索条件_新組織コード(営業所）
//                Dto010.setSearchToSosCd3(Dto010.getSelectedSosCd3());
//            }
        }
//       // 検索条件_現組織コード(ポップアップ用）
//       Dto010.setSearchFromSosCdPop(Dto010.getSearchFromSosCd());
//       // 検索条件_新組織コード(ポップアップ用）
//       Dto010.setSearchToSosCdPop(Dto010.getSearchToSosCd());
    }

    /**
     * 前画面から組織関連パラメータをコピーする
     * @param objectTo コピー先
     * @param objectFrom コピー元
     */
    public void copySosInfo(Object objectTo, Object objectFrom) {
        // 検索条件_組織・担当（現）_テキスト
        StringUtils.copyValue(objectTo, objectFrom, "dispFromSosJgiName");
        // 検索条件_現組織コード
        StringUtils.copyValue(objectTo, objectFrom, "searchFromSosCd");
        // 検索条件_組織（現）_テキスト
        StringUtils.copyValue(objectTo, objectFrom, "searchFromSosName");
        // 検索条件_現組織支店コード
        StringUtils.copyValue(objectTo, objectFrom, "searchFromSosCd2");
        // 検索条件_現組織支店名称
        StringUtils.copyValue(objectTo, objectFrom, "searchFromSosNm2");
        // 検索条件_現組織の組織コード３
        StringUtils.copyValue(objectTo, objectFrom, "searchFromSosCd3");
        // 検索条件_現組織の組織コード４
        StringUtils.copyValue(objectTo, objectFrom, "searchFromSosCd4");

        // 検索条件_組織・担当（新）_テキスト
        StringUtils.copyValue(objectTo, objectFrom, "dispToSosJgiName");
        // 検索条件_新組織コード
        StringUtils.copyValue(objectTo, objectFrom, "searchToSosCd");
        // 検索条件_組織（新）_テキスト
        StringUtils.copyValue(objectTo, objectFrom, "searchToSosName");
        //検索条件_組織コード（新）（営業所）
        StringUtils.copyValue(objectTo, objectFrom, "searchToSosCd3");

        // 検索条件_現従業員番号
        StringUtils.copyValue(objectTo, objectFrom, "searchFromJgiNo");
        // 検索条件_現従業員
        StringUtils.copyValue(objectTo, objectFrom, "searchFromJgiName");
        // 検索条件_新従業員番号
        StringUtils.copyValue(objectTo, objectFrom, "searchToJgiNo");
        // 検索条件_新従業員
        StringUtils.copyValue(objectTo, objectFrom, "searchToJgiName");

        // 施設表示範囲設定フラグ
        StringUtils.copyValue(objectTo, objectFrom, "insDispRngFlg");
    }
    // END UOC
}
