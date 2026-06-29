# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: Optional[TreeNode]
        """
        inorder_map = {val: idx for idx, val in enumerate(inorder)}
        def helper(left_idx, right_idx):
            if left_idx > right_idx:
                return None
            root_val = postorder.pop()
            root = TreeNode(root_val)
            pivot_idx = inorder_map[root_val]
            root.right = helper(pivot_idx + 1, right_idx)
            root.left = helper(left_idx, pivot_idx - 1)
            return root
        return helper(0, len(inorder) - 1)
