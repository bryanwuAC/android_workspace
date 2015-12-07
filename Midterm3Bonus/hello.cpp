#include <iostream>
#include <string>

using std::string;
using std::cout;
using std::endl;

int main()
{
   for(int i=1; i<17; i++) {
      for(int j=1 ; j<17; j++){
       cout << i*j<<"\t";
      }
    cout << endl;
   }
   return 0;
}
