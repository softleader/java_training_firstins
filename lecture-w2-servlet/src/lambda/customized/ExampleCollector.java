package lambda.customized;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ExampleCollector {
	
	
	
	public static Collector<String, List, List> apply() {
		return new Collector() {

			@Override
			public Supplier supplier() {
				return ExampleCollector.supplier();
			}

			@Override
			public BiConsumer accumulator() {
				return ExampleCollector.accumulator();
			}

			@Override
			public BinaryOperator combiner() {
				return (old, n) -> {
					ExampleCollector.combiner().accept((ArrayList)old, (ArrayList)n);
					return old;					
				};
			}

			@Override
			public Function<List, List> finisher() {
				return list -> list;
			}

			@Override
			public Set characteristics() {
				return new LinkedHashSet();
			}
			
		};
		
		
//		Stream.of("a", "b").collect(
//				() -> new ArrayList(),
//				(ArrayList container, String element) -> container.add(element),
//				(ArrayList container1, ArrayList container2) -> container1.addAll(container2));
//		
//		Stream.of("a", "b").collect(supplier(), accumulator(), combiner());
//		
//		Stream.of("a", "b").collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
	}

	private static BiConsumer<ArrayList, ArrayList> combiner() {
		return (ArrayList container1, ArrayList container2) -> container1.addAll(container2);
	}

	private static BiConsumer<ArrayList, String> accumulator() {
		return (ArrayList container, String element) -> container.add(element);
	}

	private static Supplier<ArrayList> supplier() {
		return () -> new ArrayList();
	}

}
