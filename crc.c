
#include<stdio.h>
#include<string.h>

#define N strlen(gen_poly)

char data[28];

char check_value[28];

char gen_poly[10];

int data_length,i,j;

void XOR(){
    
    for(j = 1;j < N; j++)
    check_value[j] = (( check_value[j] == gen_poly[j])?'0':'1');
    
}

void receiver(){

    printf("Enter the received data: ");
    scanf("%s", data);
    printf("\n\n");
    printf("Data received: %s", data);

    crc();

    for(i=0;(i<N-1) && (check_value[i]!='1');i++);
        if(i<N-1)
            printf("\nError detected\n\n");
        else
            printf("\nNo error detected\n\n");
}

void crc(){
   
    for(i=0;i<N;i++)
        check_value[i]=data[i];
    do{
    
        if(check_value[0]=='1')
            XOR();

        for(j=0;j<N-1;j++)
            check_value[j]=check_value[j+1];
        // appending a bit from data
        check_value[j]=data[i++];
    }while(i<=data_length+N-1);
// loop until the data ends
}

int main()
{
    // get the data to be transmitted
    printf("\nEnter data to be transmitted: ");
    scanf("%s",data);
    printf("\n Enter the Generating polynomial: ");
    // get the generator polynomial
    scanf("%s",gen_poly);
    // find the length of data
    data_length=strlen(data);
    // appending n-1 zeros to the data
    for(i=data_length;i<data_length+N-1;i++)
        data[i]='0';
    printf("\n");
// print the data with padded zeros
    printf("\n Data padded with n-1 zeros : %s",data);
    printf("\n");
// Cyclic Redundancy Check
    crc();
// print the computed check value
    printf("\nCRC or Check value is : %s",check_value);
// Append data with check_value(CRC)  
    for(i=data_length;i<data_length+N-1;i++)
        data[i]=check_value[i-data_length];
    printf("\n");
// printing the final data to be sent
    printf("\n Final data to be sent : %s",data);
    printf("\n\n");
// Calling the receiver function to check errors
    receiver();
        return 0;
}
