#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main()
{
	char s[101];
	int i,l,cnt=0;
	scanf("%s", s);
	l = strlen(s);
	s[l + 1] = '\0';
	for (i = 0; i < l; i++)
	{
		if (s[i] == 'c' && s[i + 1] == '=')
		{
			cnt++;
			i++;
		}
		else if (s[i] == 'c' && s[i + 1] == '-')
		{
			cnt++;
			i++;
		}
		else if (s[i] == 'd' && s[i + 1] == 'z' && s[i + 2] == '=')
		{
			cnt++;
			i=i+2;
		}
		else if (s[i] == 'd' && s[i + 1] == '-')
		{
			cnt++;
			i++;
		}
		else if (s[i] == 'l' && s[i + 1] == 'j')
		{
			cnt++;
			i++;
		}
		else if (s[i] == 'n' && s[i + 1] == 'j')
		{
			cnt++;
			i++;
		}
		else if (s[i] == 's' && s[i + 1] == '=')
		{
			cnt++;
			i++;
		}
		else if (s[i] == 'z' && s[i + 1] == '=')
		{
			cnt++;
			i++;
		}
		else
			cnt++;
	}
	printf("%d", cnt);
	return 0;
}
