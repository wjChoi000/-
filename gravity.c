#if 1
#pragma warning(disable:4996)


#include<stdio.h>
#include <stdlib.h>

#define S 'C'
#define D 'D'
#define WALL '#'
#define EMPTY '.'
#define UP -1
#define DOWN 1
#define RITHG  10
#define LEFT -10

typedef struct _queue {
	int y, x, g,b;
	int count;
	struct _queue *next, *prev;
}Queue;

Queue head, tail;

int isEmpty() {
	if (head.next == &tail)
		return 1;
	return 0;
}

void push(Queue* d) {
	d->next = head.next;
	d->prev = &head;

	head.next->prev = d;
	head.next = d;
}

Queue* pop() {
	if (isEmpty())
		return NULL;
	Queue* temp = tail.prev;
	temp->prev->next = &tail;
	tail.prev = temp->prev;
	return temp;
}

Queue* init(int y, int x, int count,int g,int b) {
	Queue* t = calloc(1, sizeof(Queue));
	t->y = y;
	t->x = x;
	t->g = g;
	t->b = b;
	t->count = count;
}

char MAP[510][510];
int N, M;

void PQ() {
	Queue* temp = head.next;
	printf("===========\n");
	while (temp != &tail) {
		printf("y=%d, x=%d,c=%d,g=%d \n", temp->y, temp->x, temp->count, temp->g);
		temp = temp->next;
	}
}

int main() {
	scanf("%d %d", &N, &M);

	head.next = &tail;
	head.prev = NULL;
	tail.prev = &head;
	tail.next = NULL;

	int i,j;
	for (i = 0; i < N; i++)
		scanf("%s", &MAP[i]);
	int x, y, ex, ey;
	for (i = 0; i < N; i++) {
		for (j = 0; j < M; j++) {
			if (MAP[i][j] == S) {
				x = j;
				y = i;

			}
			if (MAP[i][j] == D) {
				ex = j;
				ey = i;

			}
		}
	}
	
	push(init(y, x, 0,DOWN,0));
	Queue* current;
	
	while (isEmpty()==0) {
		
		current = pop();
		if (current==NULL)
			break;
		//철수
		if (current->y == ey && current->x == ex) {
			printf("%d", current->count);
			return 0;
		}
		//격자 하강
		while (1) {
			
			if (current->y <= 0 || current->y >= N - 1) {
				break;
			}
			// 격자 여부
			if (current->y + current->g >=0 && current->y + current->g<= N-1 && MAP[current->y + current->g][current->x] == WALL)
				break;
			current->y += current->g;
		
			//철수
			if (current->y == ey && current->x == ex) {
				printf("%d", current->count);
				return 0;
			}

			
		}

		//격자 여부
		if (current->y <= 0 || current->y >= N - 1) {
			free(current);
			continue;
		}
		//왼쪽 
		if (current->x - 1 >= 0)
			if(current->b != RITHG && MAP[current->y][current->x - 1]==EMPTY) {
			push(init(current->y, current->x - 1, current->count, current->g,LEFT));
			}
		//오른쪽 이동
		if (current->x +1 <= M-1)
			if(current->b != LEFT && MAP[current->y][current->x + 1] == EMPTY) {
			push(init(current->y, current->x + 1, current->count, current->g, RITHG));
			}
		//중력반전
		if (current->b != DOWN && current->b != UP) {
			if(current->g==DOWN)
				push(init(current->y, current->x , current->count+1, UP, DOWN));
			else
				push(init(current->y, current->x, current->count + 1, DOWN, UP));
		}
		//PQ();
		free(current);
	}

	printf("-1");
	return 0;
}
#endif
