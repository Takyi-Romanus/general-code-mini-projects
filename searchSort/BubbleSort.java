package searchSort;
    public class BubbleSort{
        public static void main(String[] args) {
            int tmp,num []=new int[5];
            for (int i = 0; i < num.length; i++) {
                num[i]=i+1;
            }
            System.out.println("The unsorted elements are:");
            for (int j = 0; j < num.length; j++) {
                System.out.println(num[j]);
            }
            for (int k = 0; k < num.length; k++) {
                for (int l=k+1; l < num.length; l++) {
                    if (num[k]<num[l]) {
                        tmp=num[k];
                        num[k]=num[l];
                        num[l]=tmp;
                    }
                }
            }
            System.out.println("Descending Order");
            for (int n = 0; n < num.length; n++) {
                System.out.println(num[n]);
            }
            System.out.println(num[num.length-1]);
        }
    
}
