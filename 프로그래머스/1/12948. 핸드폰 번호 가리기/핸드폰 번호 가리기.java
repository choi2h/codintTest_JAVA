class Solution {
    public String solution(String phone_number) {
        int n = phone_number.length()-4;
        return "*".repeat(n) + phone_number.substring(n);
    }
}