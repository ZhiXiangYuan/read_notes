# 功能

注册中心基于内存的实现，因为注册中心的实现方式有很多种，基于 java
内存的，基于 zookeeper 的，基于 consul 的，所以才会有了 laopopo-registry 
这个抽象模块，才会有了 rpc-registry-default 这个基于java内存实现的默认模块，
本系列目前只完成对 java 内存的实现