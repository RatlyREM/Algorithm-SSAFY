#include <iostream>
#include <set>

using namespace std;

int LIS[101];
int DP[101];

class MyComparator {
public:
     bool operator()(const pair<int, int>& p1,  const pair<int, int>& p2) const {
          return p1.first < p2.first;
     }
};

int main() {
     int N;
     cin >> N;

     set<pair<int, int>, MyComparator> mySet;


     for (int i = 0; i < N; i++) {
          int lhs, rhs;
          cin >> lhs >> rhs;

          mySet.insert(make_pair(lhs, rhs));
     }

     //DP로 LIS 찾기

     int count = 0;


     for (pair<int, int> p : mySet) {
          DP[count] = p.second;
          LIS[count] = 1;
          count++;
     }

     int maxLIS = -1;

     for (int i = 1; i < N; i++) {

          for (int j = 0; j < i; j++) {
               if (DP[j] < DP[i]) {
                    LIS[i] = max(LIS[i], LIS[j] + 1);
               }
          }

          maxLIS = max(maxLIS, LIS[i]);
     }

      cout << N - maxLIS << endl;

}