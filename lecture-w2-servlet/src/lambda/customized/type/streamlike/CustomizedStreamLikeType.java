package lambda.customized.type.streamlike;

import java.util.Arrays;
import lambda.customized.function.CustomizedF1;
import lambda.customized.function.CustomizedF2;
import lambda.customized.type.listlike.CustomizedListLikeType;

public interface CustomizedStreamLikeType {
	 CustomizedListLikeType<? extends Object> Nil = new CustomizedListLikeType<Object>() {
		public Object head() {
			return null;
		}

		public CustomizedListLikeType<Object> tail() {
			return null;
		}

		public String toString() {
			return "[]";
		}

	};

	@SuppressWarnings("unchecked")
	default <T> CustomizedListLikeType<T> nil() {
		return (CustomizedListLikeType<T>) Nil;
	}

	default <T> CustomizedListLikeType<T> cons(final T x, final CustomizedListLikeType<T> xs) {
		return new CustomizedListLikeType<T>() {
			private T head;
			private CustomizedListLikeType<T> tail;
			{
				this.head = x;
				this.tail = xs;
			}

			public T head() {
				return this.head;
			}

			public CustomizedListLikeType<T> tail() {
				return this.tail;
			}

			public String toString() {
				return head() + ":" + tail(); 
				// 當呼叫print時, 會先把head元素印出(T.toString), 再呼叫tail()印出其餘元素;
				// 當呼叫tail()時, 會呼叫ExamList.toString(), 將該層的head元素印出(T.toString())後, 再呼叫tail()印出其餘元素;
				// .
				// .
				// .
				// 直到Nil.toString(); 印出[];
			}
		};
	}

	default <T> CustomizedListLikeType<T> list(T... elems) {
		if (elems.length == 0)
			return nil();
		T[] remain = Arrays.copyOfRange(elems, 1, elems.length);
		return cons(elems[0], list(remain));
	}

	default <T, R> CustomizedListLikeType<R> map(CustomizedListLikeType<T> lt, CustomizedF1<T, R> f) {
		if(lt == Nil) return nil();
		return cons(f.apply(lt.head()), map(lt.tail(), f));
	}

	default <T> CustomizedListLikeType<T> filter(CustomizedListLikeType<T> lt,
      CustomizedF1<T, Boolean> f) {
		if(lt == Nil) return nil();  // 該層已無任何元素
		else {
			if(f.apply(lt.head())) { // 剝離一層至head 該層若滿足條件, 
				return cons(
						lt.head(),   			// 則呼叫cons 保存(當前處理元素)至新建立的ExamList物件中
						filter(lt.tail(), f)    // 其餘非head者繼續遞迴呼叫自身
						);   
				
			} else {							// 沒有新建立任何ExamList
				return filter(lt.tail(), f);    // 其餘非head者繼續遞迴呼叫自身
						
			}
			
		}
		
		
	}
	
	default <T, R> R reduce(CustomizedListLikeType<T> lt, CustomizedF2<T, R> f, R r) {
	if(lt == Nil) return r;
	else return reduce(lt.tail(), f, f.apply(r, lt.head()));
}
	
}
