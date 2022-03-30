binary search median is not meidan = (low + high) /2 because may cause overflow
when low + high is bigger than the maximum positive int value (231 - 1)
the number will become a negative value and divde by 2


this can mix it
int mid = low + ((high - low) / 2);
high - low =  range , /2 = range's mid, low + range's mid but without low so need to + low

int mid = (low + high) >>> 1;
