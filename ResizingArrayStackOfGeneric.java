package stack;

public class ResizingArrayStackGeneric<Type> {
		private Type[] t;
		private int pos = 0;
		
		@SuppressWarnings("unchecked")
		public ResizingArrayStackGeneric(int n) {
			t = (Type[]) new Object[n];
		}
		
		public boolean isFull(Type[] tab) { return pos == tab.length; }
		
		public Type[] resize(Type[] t) {
			int n = t.length;
			@SuppressWarnings("unchecked")
			Type[] tResized = (Type[]) new Object [ 2 * n ];
			for (int i = 0; i < n; i++) {
		  		tResized[i] = t[i];
			}
			return tResized;
		}
		
		public boolean isEmpty() { return pos == 0; }
		public void push(Type item) {
			if (this.isFull(t)) t = resize(t);
				t[pos++] = item;
		}
		
		public Type pop() {
			if (isEmpty()) return null;
			Type val = t[--pos];
			t[pos] = null; //prevent from loitering
			return val;
		}
		

		public static void main(String[] args) {
			/*ResizingArrayStackGeneric<String> stack = new ResizingArrayStackGeneric<String>(3);
			stack.push("a");
			System.out.println(stack.pop());
			System.out.println(stack.pop());*/		
		}
}
