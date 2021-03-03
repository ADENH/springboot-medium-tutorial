package com.demo.medium.serviceimpl;

public class GenderConverter {
	public enum gender {
        PRIA,WANITA
    }
	
	public static gender convert(int genderCode) {
		if(genderCode == 1) {
			return gender.PRIA;
		}else if(genderCode == 2) {
			return gender.WANITA;
		}
		return null;
	}
}
