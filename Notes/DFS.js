// tree {
//   int val
//   node left
//   node right
// }

// Recursive
function dfs(tree, val) {
    if (tree === null) {
        return false;
    }

    if (tree.val === search) {
        return true;
    }

    return (dfs(tree.left, search) || dfs(tree.right, search));
}

// Iterative
function dfs(tree, val) {
    // let stack = []

    stack.push(tree);
    while (stack.length > 0) {
        // let node = stack.pop();

        if (node.val === val) {
            return true;
        }

        if (node.left) {
            stack.push(node.left);
        }
        if (node.right) {
            stack.push(node.right);
        }
    }

    return false;
}