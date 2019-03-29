public class ArrayList <T> implements List<T>{
	private int length;
	private int size;
	private Object [] temp1;
	private T arr[];

	public ArrayList (){
		length=10;
		size =0;
		//casting object into type T
		temp1 = new Object[length];
		arr = (T[])temp1;
	}

/////////////////////////////////////////////////////////////////////////////////////////

	//function to add element to the end of the list
	public void add (T element){
		if(size() == arr.length-1){
			expandArray();
		} 
		arr[size++] = element;

	}
/////////////////////////////////////////////////////////////////////////////////////////

	//function to add element to specified index of list of the list
	public void add (int pos , T element){
		if (size() == arr.length){
			expandArray();
		}

		for (int i=arr.length-1;i>pos;i--){
			arr[i] = arr[i-1];

		}
			arr[pos] = element;
			size++;
	}

/////////////////////////////////////////////////////////////////////////////////////////

	// returns number of elements inside the array
	public int size(){
		return size;
	}

/////////////////////////////////////////////////////////////////////////////////////////

	//gets the object located at a specific index
	public T get(int pos){
		if (pos>0 || pos<size){
			return arr[pos];
		}
		return null;		
	}

/////////////////////////////////////////////////////////////////////////////////////////

	//removes an object from the specified index
	public T remove(int pos){
		T temp = arr[pos];
		if (size() == 0 || pos>=size || pos<0){
			return null;
		}
		if (size() == arr.length){
			expandArray();
		}
		for(int i=pos;i<arr.length-1;i++){
			arr[i]= arr[i+1];
		}

		size--;

		return temp;

	}

/////////////////////////////////////////////////////////////////////////////////////////
	
	// expands array length by double in each call
	private void expandArray (){

		Object [] temp2 = new Object [arr.length*2];
		T[] newTemp = (T[]) temp2;


		for (int index=0; index<arr.length;index++){
			newTemp[index] = arr[index];
		}

		
		arr = newTemp;
	}

}