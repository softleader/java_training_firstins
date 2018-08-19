package lambda.customized;

import lambda.customized.function.CustomizedF1;
import lambda.customized.type.helperlike.CustomizedHelperLikeType;
import lambda.customized.type.streamlike.impl.CustomizedStreamLikeTypeImpl;

public class CustomizedLambdaExecutor {

	public static void main(String[] args) {
		CustomizedF1<Integer, Boolean> condition = a -> a > 1;
		CustomizedF1<Integer, String> mapper = a -> "號碼[" + a + "]";


		// 即使改成static import, 仍依舊像是函數呼叫, 而非管線操作.
		System.out.println(CustomizedHelperLikeType.cons(1, CustomizedHelperLikeType.nil()));
		System.out.println(CustomizedHelperLikeType.cons(1, CustomizedHelperLikeType.cons(2, CustomizedHelperLikeType.nil())));		
		System.out.println(CustomizedHelperLikeType.cons(1, CustomizedHelperLikeType.cons(2, CustomizedHelperLikeType.cons(3, CustomizedHelperLikeType.nil()))));

		CustomizedHelperLikeType.map(
				CustomizedHelperLikeType.filter(
						CustomizedHelperLikeType.list(1, 2, 3), condition), mapper);


		// Java8 default method 預設方法
		System.out.println(new CustomizedStreamLikeTypeImpl().cons(1, new CustomizedStreamLikeTypeImpl().nil()));
		System.out.println(new CustomizedStreamLikeTypeImpl().cons(1, new CustomizedStreamLikeTypeImpl().cons(2, new CustomizedStreamLikeTypeImpl().nil())));
		System.out.println(new CustomizedStreamLikeTypeImpl().cons(1, new CustomizedStreamLikeTypeImpl().cons(2, new CustomizedStreamLikeTypeImpl().cons(3, new CustomizedStreamLikeTypeImpl().nil()))));
		// 呼叫cons時先將1設定為head,
		// 再將tail設定為
			// 呼叫cons時先將2設定為head,
			// 再將tail設定為
				// 呼叫cons時先將3設定為head, 
				// 再將tail設定為Nil(head為null; tail為null; toString()為[]）

		
		System.out.println(CustomizedStreamLikeTypeImpl.of(1, 2, 3)
				.filter(condition)
				.map(mapper)
				.get());
		
		
		// CustomizedListLikeType(1, CustomizedListLikeType(2, CustomizedListLikeType(3, Nil))
		
		// {head:1, tail:{
		//                head:2, tail:{
		//         				        head:3, tail:{
		//                                            head: null, tail: null}
		
		
		
		
	}

}
