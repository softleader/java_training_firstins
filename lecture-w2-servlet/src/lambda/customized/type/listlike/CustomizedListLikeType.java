package lambda.customized.type.listlike;
public interface CustomizedListLikeType<T> {
	T head();
	CustomizedListLikeType<T> tail();
}
