package com.mrkumar.sqlitedbstoreapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseApi{

	@SerializedName("ResponseApi")
	private List<ResponseApiItem> responseApi;

	public List<ResponseApiItem> getResponseApi(){
		return responseApi;
	}
}