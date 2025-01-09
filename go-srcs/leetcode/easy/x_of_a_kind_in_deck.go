package easy

// task link - https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/

func hasGroupsSizeX(deck []int) bool {
	partitions := make(map[int]int)
	for i := 0; i < len(deck); i += 1 {
		partitions[deck[i]]++
	}
	prev := -1
	for _, count := range partitions {
		if count <= 1 {
			return false
		}
		if prev == -1 {
			prev = count
		}
		prev = gcd(count, prev)
		if prev == 1 {
			return false
		}
	}
	return true
}

func gcd(a, b int) int {
	for b != 0 {
		a, b = b, a%b
	}
	return a
}
