# Merge

## 创建并开启自定义驱动

```
master# git config --global merge.ours.driver true
```

## 配置驱动策略

```
master# echo 'test.txt merge=ours' >> .gitattributes
master# git add .gitattributes
master# git commit -m 'chore: Preserve test.txt during merges'
```

## 测试合并策略

```
master# git checkout feature/support
feature/support# git rebase master
如果这里有冲突解决冲突，然后合并test.txt
再修改test.txt中的内容使其与master分支中的test.txt内容不同，待会儿查看结果。
feature/support# git checkout master
master# git merge -s ours feature/support
```

## 查看结果

master主分支和dev分支的feature/support内容不同，
feature/support分支test.txt并没有合并到master分支中，说明我们的合并策略生效。