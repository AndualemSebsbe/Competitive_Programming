package AfterCamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class mergeAccounts {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
                
        final Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < accounts.size(); i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                if(!map.containsKey(accounts.get(i).get(j))){
                    map.put(accounts.get(i).get(j), i);
                }
                else{
                    uf.union(map.get(accounts.get(i).get(j)), i);
                }
            }
        }
        
        // go through each account and find the UF root and merge
        Map<Integer, Account> rootAccounts = new HashMap<>();
		for (int accId = 0; accId < accounts.size(); accId++) {
			List<String> account = accounts.get(accId);

			int rootAccId = uf.find(accId);
			if (!rootAccounts.containsKey(rootAccId)) {
				String rootAccName = accounts.get(rootAccId).get(0);
				rootAccounts.put(rootAccId, new Account(rootAccName));
			}
			List<String> emails =  account.subList(1, account.size());
			rootAccounts.get(rootAccId).emails.addAll(emails);
		}

		return rootAccounts.values().stream()
						.map(acc -> acc.toStringList())
						.collect(Collectors.toList());
    }
}

 class UnionFind{
    int[] parents;
    // int[] size;
    
    public UnionFind(int n){
        parents = new int[n];
        // size = new int[n];
        
        for(int i = 0; i < parents.length; i++){
            parents[i] = i;
            // size[i] = 1;
        }
    }
    
    public int find(int v){
        if(v == parents[v])
            return v;
        return parents[v] = find(parents[v]);
    }

    public void union(int a, int b){
       int aParent = find(a);
       int bParent = find(b);
        
        if(aParent == bParent)
            return;
        parents[bParent] = aParent;
        // if(aParent < bParent){
        //     parents[bParent] = aParent;
        // }
        // else{
        //     parents[aParent] = bParent;
        // }
    }
}

class Account {
		String name;
		Set<String> emails = new TreeSet<>();

		Account(String name) {
			this.name = name;
		}

		List<String> toStringList() {
			List<String> list = new ArrayList<>();
			list.add(name);
			list.addAll(emails);
			return list;
		}
	}