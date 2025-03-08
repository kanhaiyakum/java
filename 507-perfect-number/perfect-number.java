// class Solution {
//     public boolean checkPerfectNumber(int num) {
//         int sum =0;
//         for(int i=1;i<=num/2;i++){
//             if(num%i==0){
//                 sum+=i;
//             }
//         }if(sum==num)return true;
//         else return false;
//     }
// }

class Solution {
    public boolean checkPerfectNumber(int num) {
        switch (num) {
            case 6:
            case 28:
            case 496:
            case 8128:
            case 33550336:
                return true;
            default:
                return false;
        }
    }
}