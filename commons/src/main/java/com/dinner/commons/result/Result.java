package com.dinner.commons.result;




import com.dinner.commons.BaseResult;
import lombok.Data;


@Data
public class Result<T> extends BaseResult {
	//返回数据
	private T data;

	public Result(){}
	public Result(Integer code, String msg) {
		super.setCode(code);
		super.setMsg(msg);
	}

	public Result(ResultCodeEnum resultCodeEnum) {
		if (resultCodeEnum != null) {
			super.setCode(resultCodeEnum.getCode());
			super.setMsg(resultCodeEnum.getMsg()); ;
		}
	}

	public Result(T data) {
		setCode(ResultCodeEnum.SUCCESS.getCode());
		setMsg(ResultCodeEnum.SUCCESS.getMsg());
		this.data = data;
	}


	/**
	 *  成功时候的调用
	 * */
	public static  <T> Result<T> success(T data){
		return new Result<T>(data);
	}

	/**
	 *  成功时候的调用
	 * */
	public static  Result<Void> success(){
		return new Result<Void>(ResultCodeEnum.SUCCESS);
	}

	/**
	 *  成功时候的调用
	 * */
	public static  Result<Void> success(Integer code, String msg){
		return new Result<Void>(code, msg);
	}


	/**
	 *  失败时候的调用
	 * */
	public static  <T> Result<T> error(ResultCodeEnum ResultCodeEnum){
		return new Result<T>(ResultCodeEnum);
	}

	/**
	 *  失败时候的调用
	 * */
	public static  <T> Result<T> error(Integer code, String msg){
		return new Result<T>(code, msg);
	}


}
