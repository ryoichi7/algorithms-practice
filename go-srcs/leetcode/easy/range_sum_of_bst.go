package easy

// task link - https://leetcode.com/problems/range-sum-of-bst/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func rangeSumBST(root *TreeNode, low int, high int) int {
	var sum int

	countRangeSum(root, &sum, low, high)

	return sum
}

func countRangeSum(cur *TreeNode, sum *int, low int, high int) {
	if cur == nil {
		return
	}
	if cur.Val >= low && cur.Val <= high {
		*sum += cur.Val
	}
	countRangeSum(cur.Left, sum, low, high)
	countRangeSum(cur.Right, sum, low, high)
}
