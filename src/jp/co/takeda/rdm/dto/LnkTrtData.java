/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * DTOクラス 領域・品目グループ
 * @generated
 */
public class LnkTrtData implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 領域グループコード
     * @generated
     */
    private String trtGrpCd;

    /**
     * 領域コード
     * @generated
     */
    private String trtCd;

    /**
     * 領域名
     * @generated
     */
    private String trtNm;

    /**
     * 品目グループコード
     * @generated
     */
    private String hinGCd;

    /**
     * 品目グループ名
     * @generated
     */
    private String hinGName;

    /**
     * 表示順_領域
     * @generated
     */
    private String dispSortTrt;

    /**
     * 表示順_領域品目グループ
     * @generated
     */
    private String dispSortTrtPrd;

    /**
     * 施設略式漢字名
     * @generated
     */
    private String insAbbrName;

    /**
     * 対象区分
     * @generated
     */
    private String hoInsType;

    /**
     * 住所
     * @generated
     */
    private String insAddr;

    /**
     * 担当者
     * @generated
     */
    private String jgiName;

    /**
     * コンストラクタ
     * @customizable
     */
    public LnkTrtData() {
        // START UOC

        // END UOC
    }

	/**
	 * LnkTrtData.javatrtGrpCdを設定
	 * @return trtGrpCd
	 */
	public String getTrtGrpCd() {
		return trtGrpCd;
	}

	/**
	 * @param trtGrpCd セットする trtGrpCd
	 */
	public void setTrtGrpCd(String trtGrpCd) {
		this.trtGrpCd = trtGrpCd;
	}

	/**
	 * LnkTrtData.javatrtCdを設定
	 * @return trtCd
	 */
	public String getTrtCd() {
		return trtCd;
	}

	/**
	 * @param trtCd セットする trtCd
	 */
	public void setTrtCd(String trtCd) {
		this.trtCd = trtCd;
	}

	/**
	 * LnkTrtData.javatrtNmを設定
	 * @return trtNm
	 */
	public String getTrtNm() {
		return trtNm;
	}

	/**
	 * @param trtNm セットする trtNm
	 */
	public void setTrtNm(String trtNm) {
		this.trtNm = trtNm;
	}

	/**
	 * LnkTrtData.javahinGCdを設定
	 * @return hinGCd
	 */
	public String getHinGCd() {
		return hinGCd;
	}

	/**
	 * @param hinGCd セットする hinGCd
	 */
	public void setHinGCd(String hinGCd) {
		this.hinGCd = hinGCd;
	}

	/**
	 * LnkTrtData.javahinGNameを設定
	 * @return hinGName
	 */
	public String getHinGName() {
		return hinGName;
	}

	/**
	 * @param hinGName セットする hinGName
	 */
	public void setHinGName(String hinGName) {
		this.hinGName = hinGName;
	}

	/**
	 * LnkTrtData.javadispSortTrtを設定
	 * @return dispSortTrt
	 */
	public String getDispSortTrt() {
		return dispSortTrt;
	}

	/**
	 * @param dispSortTrt セットする dispSortTrt
	 */
	public void setDispSortTrt(String dispSortTrt) {
		this.dispSortTrt = dispSortTrt;
	}

	/**
	 * LnkTrtData.javadispSortTrtPrdを設定
	 * @return dispSortTrtPrd
	 */
	public String getDispSortTrtPrd() {
		return dispSortTrtPrd;
	}

	/**
	 * @param dispSortTrtPrd セットする dispSortTrtPrd
	 */
	public void setDispSortTrtPrd(String dispSortTrtPrd) {
		this.dispSortTrtPrd = dispSortTrtPrd;
	}

	/**
	 * LnkTrtData.javainsAbbrNameを設定
	 * @return insAbbrName
	 */
	public String getInsAbbrName() {
		return insAbbrName;
	}

	/**
	 * @param insAbbrName セットする insAbbrName
	 */
	public void setInsAbbrName(String insAbbrName) {
		this.insAbbrName = insAbbrName;
	}

	/**
	 * LnkTrtData.javahoInsTypeを設定
	 * @return hoInsType
	 */
	public String getHoInsType() {
		return hoInsType;
	}

	/**
	 * @param hoInsType セットする hoInsType
	 */
	public void setHoInsType(String hoInsType) {
		this.hoInsType = hoInsType;
	}

	/**
	 * LnkTrtData.javainsAddrを設定
	 * @return insAddr
	 */
	public String getInsAddr() {
		return insAddr;
	}

	/**
	 * @param insAddr セットする insAddr
	 */
	public void setInsAddr(String insAddr) {
		this.insAddr = insAddr;
	}

	/**
	 * LnkTrtData.javajgiNameを設定
	 * @return jgiName
	 */
	public String getJgiName() {
		return jgiName;
	}

	/**
	 * @param jgiName セットする jgiName
	 */
	public void setJgiName(String jgiName) {
		this.jgiName = jgiName;
	}

	/**
     * このDTOの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}

