#!/bin/bash

GS_ROOT=/home/baudryj/workspace-gs

GS_CORE=$GS_ROOT/gs1-core
GS_DISTRI=$GS_ROOT/gs1-distributed

GS_CORE_BIN=$GS_CORE/bin
GS_CORE_SRC=$GS_CORE/src

GS_DISTRI_BIN=$GS_DISTRI/bin
GS_DISTRI_SRC=$GS_DISTRI/src

CP=$GS_CORE/gs-core.jar:$GS_CORE/lib/batik-awt-util.jar:$GS_CORE/lib/batik-dom.jar:$GS_CORE/lib/batik-svggen.jar:$GS_CORE/lib/batik-util.jar:$GS_CORE/lib/batik-xml.jar:$GS_CORE/lib/book.jar:$GS_CORE/lib/mbox2.jar:$GS_CORE/lib/metouia.jar:$GS_CORE/lib/miterator.jar:$GS_CORE/lib/pherd.jar:$GS_CORE/lib/util.jar:$GS_CORE/lib/xml-apis.jar:$GS_CORE/lib/jsch-0.1.38.jar:$GS_DISTRI/gs-distributed.jar:$GS_DISTRI/lib/jsch-0.1.38.jar:$GS_DISTRI/lib/jnlp.jar:$GS_DISTRI/lib/appFramework-1.0.jar:$GS_DISTRI_BIN:$GS_CORE_BIN:.

. env2.sh 

ps aux | grep rmiregistry | grep -v grep | awk '{print "kill " $2}' | sh
ps aux | grep graphstream | grep -v grep | awk '{print "kill " $2}' | sh
sleep 2
cd $GS_DISTRI_BIN
export CLASSPATH=$CP
rmiregistry 
