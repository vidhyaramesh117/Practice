void main()
{
  print("\nSETS");
  var set1 = {"ce","me","ct","ec","eee"};
  
  print("Set1 = $set1");

  Set set2 = new Set();
  set2.add(150);
  set2.add(500);
  set2.add(30);
  set2.add(58);
  set2.add(115);
  print(set2);
  print("Default = ${set2.runtimeType}");
  for(var i in set2)
  {
    print(i);
  }

  print("\nMAPS");
  var account = {"user1":"Psycho","Pass1":"123"};
  print(account);

  account["Capta1"] = "qgdk" ;
  print(account);

  print(account.keys);
  print(account.values);
  print(account.length);
  print(account.isEmpty);
  print(account.isNotEmpty);
  print(account);

  print("FUNCTIONS");

  account.addAll({"user2":"Joker","Pass2":"12345","Capta2":"lmvz"});
  print("New account = $account");

  account.forEach((key, value) 
  {
    print(key);
    print(value);
  });
  account.forEach((key, value) 
  {
    print(key+":"+value);
  });

  account.remove("Pass1");
  print(account);

  account.clear();
  print(account);
  

}