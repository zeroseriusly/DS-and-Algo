#include<bits/stdc++.h>
using namespace std;
// bool carPooling(vector<vector<int>>& trips, int capacity) {   leetcode solution
        
//         int finaldrop=-1;
//         for(vector<int>trip: trips){
//           finaldrop= max(finaldrop, trip[2]);
//         }
//         vector<int>prefixsum(finaldrop+1, 0);
//         for(vector<int>trip: trips){
//           prefixsum[trip[1]]+=trip[0];
//             prefixsum[trip[2]]-=trip[0];
          
//         }
//         for(int i=0; i<finaldrop; i++){
//          prefixsum[i+1]+=prefixsum[i];
//           if(prefixsum[i]>capacity){
//                return false;
//           } 
//         }
//         return true;
        
//     }

int main(){
    vector<vector<int>> trips={{2,1,5},
                               {3,3,7},
                               {2,4,5}};
    int capacity=5;
     int finaldrop=-1;
        for(vector<int>trip: trips){
          finaldrop= max(finaldrop, trip[2]);
        }
        vector<int>prefixsum(finaldrop+1, 0);
        for(vector<int>trip: trips){
          prefixsum[trip[1]]+=trip[0];
            prefixsum[trip[2]]-=trip[0];
          
        }
        for(int i=0; i<finaldrop; i++){
         prefixsum[i+1]+=prefixsum[i];
          if(prefixsum[i]>capacity){
               cout<<"False"<<endl;
               cout<<trips.size();
               return 0;
          } 
        }
        cout<<"True"<<endl;
        cout<<trips.size();
    return 0;
}