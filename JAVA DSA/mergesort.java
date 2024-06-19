public class mergesort {

    public static void conquer(int[]arr,int si,int mid,int ei){
        int[] merge = new int[ei-si+1];
        int idx1 = si;
        int idx2 = mid+1;
        int i=0;

        while(idx1<=mid && idx2<=ei){
            if(arr[idx1] <= arr[idx2]){
                merge[i++] = arr[idx1++];
            }else{
                merge[i++] = arr[idx2++];
            }
        }

        while (idx1<=mid) {
            merge[i++] = arr[idx1++];
        }
        while(idx2 <=ei){
            merge[i++] = arr[idx2++];
        }

        for(int j=0,k=si;j<merge.length;j++,k++){
            arr[k] = merge[j];
        }
    }
    public static void divide(int[] arr,int si,int ei){
       // if(si >= ei) return;
        if(si < ei){
        int mid = si + (ei -si)/2;

        divide(arr,si,mid);
        divide(arr,mid+1,ei);
        conquer(arr,si,mid,ei);
        }
    }
    public static void main(String[] args){
        int[] arr = {9,8,6,5,2,1};

        divide(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
