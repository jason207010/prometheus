基于Lucene、Webcollector、Spring、MySQL、JPA的博客垂直搜索引擎，目前可抓取CSDN、博客园的文章。

前期准备：

1、安装中文分词工具到本地maven仓库：

```sh
git clone https://github.com/blueshen/ik-analyzer.git
```

```sh
cd ik-analyzer
```

```sh
mvn install -Dmaven.test.skip=true
```