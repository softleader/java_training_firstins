package lambda.customized.type.streamlike.impl;

import lambda.customized.function.CustomizedF1;
import lambda.customized.type.listlike.CustomizedListLikeType;
import lambda.customized.type.streamlike.CustomizedStreamLikeType;

public class CustomizedStreamLikeTypeImpl implements CustomizedStreamLikeType {
	public static CustomizedListLikeType lt;

	public <T> CustomizedStreamLikeTypeImpl filter(CustomizedF1<T, Boolean> f) {
		lt = filter(lt, f);
		return this;
	}
	public <T, R> CustomizedStreamLikeTypeImpl map(CustomizedF1<T, R> f) {
		lt = map(lt, f);
		return this;
	}
	public static <T> CustomizedStreamLikeTypeImpl of (T t) {
		CustomizedStreamLikeTypeImpl alg = new CustomizedStreamLikeTypeImpl();
		lt = alg.cons(t, alg.nil());
		return alg;
	}
	public static <T> CustomizedStreamLikeTypeImpl of (T... ts) {
		CustomizedStreamLikeTypeImpl alg = new CustomizedStreamLikeTypeImpl();
		lt = alg.list(ts);
		return alg;
	}
	public CustomizedListLikeType get() {
		return lt;
	}
	
}
