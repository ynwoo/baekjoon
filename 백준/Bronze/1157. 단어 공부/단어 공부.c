#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int main()
{
	char s[1000001];
	int n[26] = { 0 };
	int i,l;
	int max_i,cnt=0;
	int max=0;
	scanf("%s", s);
	l = strlen(s);
	for (i = 0; i < l; i++)
	{
		if (s[i] >= 'a' && s[i] <= 'z')
			n[s[i] - 'a']++;
		else if (s[i] >= 'A' && s[i] <= 'Z')
			n[s[i] - 'A']++;
		else
			continue;
	}
	/*for (i = 0; i < 26; i++)
		printf("%d ", n[i]);
	printf("\n");*/
	
	for (i = 0; i < 26; i++)
	{
		if (max < n[i])
		{
			max = n[i];
			max_i = i + 'A';
		}
		else if (max == n[i])
			max_i = '?';
	}
	
	
	printf("%c", max_i);

	return 0;
}
