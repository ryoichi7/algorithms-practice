package easy

import (
	"testing"
)

func TestHasCycle(t *testing.T) {
	// список без цикла
	node1 := &ListNode{Val: 1}
	node2 := &ListNode{Val: 2}
	node3 := &ListNode{Val: 3}
	node4 := &ListNode{Val: 4}

	node1.Next = node2
	node2.Next = node3
	node3.Next = node4
	node4.Next = nil

	if hasCycle(node1) {
		t.Errorf("Test 1 failed: expected false, got true")
	}

	// список с циклом
	node5 := &ListNode{Val: 1}
	node6 := &ListNode{Val: 2}
	node7 := &ListNode{Val: 3}
	node8 := &ListNode{Val: 4}

	node5.Next = node6
	node6.Next = node7
	node7.Next = node8
	node8.Next = node6

	if !hasCycle(node5) {
		t.Errorf("Test 2 failed: expected true, got false")
	}

	// Один узел без цикла
	node9 := &ListNode{Val: 1}

	if hasCycle(node9) {
		t.Errorf("Test 3 failed: expected false, got true")
	}

	// Один узел с зацикливанием на себе
	node10 := &ListNode{Val: 1}
	node10.Next = node10

	if !hasCycle(node10) {
		t.Errorf("Test 4 failed: expected true, got false")
	}
}
