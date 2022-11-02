class Solution {
    public int minMutation(String start, String end, String[] bank) {
	// if bank is empty - no mutations possible
	if (bank.length == 0) return -1;

	// convert bank gene strings to byte arrays
	byte[][] geneBank = new byte[bank.length][0];
	for (int i = 0; i < bank.length; i++) {
		geneBank[i] = bank[i].getBytes();
	}

	byte[] endGene = end.getBytes();

	// there is no info if the end gene could be missing in the bank, so check it present
	boolean found = false;
	for (byte[] gene : geneBank) {
		if (diff(gene, endGene, 0) == 0) {
			found = true;
			break;
		}
	}
	// end gene is not valid gene - not possible to mutate to it
	if (!found) return -1;

	// do BFS starting from start, tracking visited
	
	boolean[] visited = new boolean[bank.length];
	LinkedList<byte[]> queue = new LinkedList<>();
	queue.add(start.getBytes());
	int steps = 0;

	while (!queue.isEmpty()) {
		int len = queue.size();

		while (len-- > 0) {
			byte[] gene = queue.removeFirst();
			int diff = diff(endGene, gene, 1);
			// if diff == 0, just return prev mutations steps
			// if diff == 1, one more mutation towards prev mutations steps
			// if diff == -1 - difference in genes is > 1 -> not our mutation neighbor 
			if (diff != -1) return steps + diff;
			
			for (int i = 0; i < geneBank.length; i++) {
				// if not yet visited and differs from current gene only with one char - add to queue for further mutations
				if (!visited[i] && diff(gene, geneBank[i], 1) == 1) {
						visited[i] = true;
						queue.addLast(geneBank[i]);
				}
			}
		}

		// increment steps since visited all neighbors
		steps++;
	}

	// not found path to end
	return -1;
}

// find diff between arrays up to maxDiff or return -1 if more than maxDiff differences (stop iterating early)
public int diff(byte[] arr1, byte[] arr2, int maxDiff) {
	int diff = 0;
	for (int i = 0; i < arr1.length; i++) {
		if (arr1[i] != arr2[i]) {
			if (maxDiff == diff) return -1;
			diff++;
		}
	}
	return diff;
}
}