#!/bin/bash

sh 3-apaga.sh && \
sh 1-gerar.sh in/commons-lang3-3.5.jar && \
sh 2-construir.sh in/commons-lang3-3.5.jar commons.lang3
