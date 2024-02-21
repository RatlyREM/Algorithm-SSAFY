//
//#include <iostream>
//#include <string>
//#include <math.h>
//
//using namespace std;
//
//int main()
//{
//    string s;
//    int L;
//    long long total = 0;
//    cin >> L;
//    cin >> s;
//    
//    long long tone = 1;
//    
//    for(int i=0; i<s.length(); i++) {
//		for(int j=0; j<i; j++) {
//			tone = (tone * 31) % 1234567891;
//		}
//		//cout << "tone: " << tone << endl;
//		
//        total += (((long long)((s[i]- 'a' + 1) * tone) % 1234567891)  % 1234567891);	
//        //cout << total << endl;
//		total %= 1234567891;
//		tone = 1;
//    }
//    
//    cout << total % 1234567891 << endl;
//    
//    
//
//    return 0;
//}