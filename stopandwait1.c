#include <stdio.h>
int main()
{
    int w, i, f, frames[50];
    printf("enter window size:");
    scanf("%d", &w);
    printf("\n enter number of frames to transmit:");
    scanf("%d", &f);
    printf("\n enter %d frames:", f);
    for (i = 1; i <= f; i++)
        scanf("%d", &frames[i]);
    printf("\n with sliding window protocol the frames will be sent in the following manner (assuming no corruption of frames)\n\n");
    printf("after sending %d frames at each stage sender waits for acknowledgement sent by the reciever \n\n", w);
    for (i = 1; i <= f; i++)
    {
        if (i % w == 0)
        {
            printf("%d\n", frames[i]);
            printf("acknowledgement of above frames sent is recieved by sender\n\n");
        }
        else
            printf("%d\n", frames[i]);
    }
    if (f % w != 0)
        printf("\n acknowledgement of above frames sent is recieved by sender\n");
    return 0;
}