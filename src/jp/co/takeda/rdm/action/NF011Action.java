/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.action;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

import jp.co.takeda.rdm.common.BaseAction;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.NF011DTO;
import jp.co.takeda.rdm.service.NF011Service;
import jp.co.takeda.rdm.util.AppConstant;

/**
 * Actionクラス
 * @generated
 */
@Named("nF011Action")
@Scope("request")
public class NF011Action extends BaseAction<NF011DTO> {

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
    private NF011Service nF011Service;
    // START UOC
    // END UOC

    /**
     * コンストラクタ
     * @generated
     */
    public NF011Action() {
        dto = new NF011DTO();
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
        BaseDTO outdto = nF011Service.init(dto);
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

        // 画面タイトル制御処理
        String title = "NF011_施設新規作成";
        //ユーザ権限
        String jokenSetCd = dto.getLoginJokenSetCd();

        dto.setTitle(title);

        //モック
//        dto.setUltInsCd("001100020");
//        dto.setReqId("250114-000112"); // 領域担当者有req
//        dto.setReqId("250124-000145");

        String preScreenId = loginInfo.getPreScreenId();
        String reqId = dto.getReqId();
        String ultCd = dto.getUltInsCd();
        dto.setPreScreenId(preScreenId);

        //モック
//        String kbn = "1";
//        if(kbn.equals("0")) {
//	        preScreenId = "NF001";
//	        dto.setLoginJgiNo("8830034");
//	        dto.setReqId("");
//        } else {
//	        preScreenId = "NC011";
//	        dto.setLoginJgiNo("8830034");
//	//        dto.setLoginJgiNo("0");
//	        //dto.setReqStsCd("01");
//	        dto.setLoginJokenSetCd("JKN0813");	// 管理者
//	        //dto.setLoginJokenSetCd("JKN0023");	// MR
//        }

        // 遷移パターン　0:完全新規、1:ULTから作成、2：申請データあり
        // ULT施設コード　ありなしで分岐
        // NF001_施設検索
        if ("NF001".equals(preScreenId)) {
        	if (ultCd != null && ultCd.length() > 0) {
        		// ULT施設コードで初期データ作成
        		dto.setDisplayKbn("1");
        	} else if(ultCd == null || ultCd.length() == 0){
        		// 完全新規
        		dto.setDisplayKbn("0");
        	} else { //遷移エラー
        	}
        }
        // 申請ID
        // NC011_申請一覧
        // NF301_施設新規作成 - 申請内容確認
        // NM101_通知内容詳細
        if ("NC011".equals(preScreenId) || "NF301".equals(preScreenId) || "NM101".equals(preScreenId)) {
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
        sessionMap.put(AppConstant.SESKEY_NF011_SEARCHKEY, outdto);
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
        BaseDTO outdto = nF011Service.register(dto);
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
//        if (!RdmConstantsData.M0122740.equals(StringUtils.nvl(dto.getMsgId(),""))
//                && !RdmConstantsData.M0001102.equals(StringUtils.nvl(dto.getMsgId(),""))
//                && !RdmConstantsData.M0001101.equals(StringUtils.nvl(dto.getMsgId(),""))
//                && !"exception".equals(outdto.getForward())){
//            setJumpInfo(dto.getMsgId());
//            outdto.setForward(dto.getForward());
//        }
        // END UOC
    	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

		// 本画面を再表示
		outdto.setForward("NF011");

        setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 業務処理
     * @customizable
     */
    @InputConfig(methodName="validationError")
    public String cancel() throws Exception {
        cancelSetup();
        // F層呼び出し
        BaseDTO outdto = nF011Service.cancel(dto);
        outdto = nF011Service.init(dto);
        return cancelNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void cancelSetup() throws Exception {
        // START UOC

        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String cancelNext(BaseDTO outdto) throws Exception {
        // START UOC

    	// 前画面に遷移
        outdto.setForward(outdto.getPreScreenId());

        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 業務処理
     * @customizable
     */
    @InputConfig(methodName="validationError")
    public String shnComp() throws Exception {
        registerSetup();
        // F層呼び出し
        BaseDTO outdto = nF011Service.shnComp(dto);
        outdto = nF011Service.init(dto);
        return shnCompNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void shnCompSetup() throws Exception {
        // START UOC
        dto.setMsgId(null);
        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String shnCompNext(BaseDTO outdto) throws Exception {
    	// START UOC
    	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

    	// END UOC
    	outdto.setForward("NF011");
        setNextDTO(outdto);
        return outdto.getForward();
    }
}
