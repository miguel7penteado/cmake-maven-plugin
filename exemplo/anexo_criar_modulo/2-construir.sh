
CAMINHO_PACOTE_JAR=$1
NOME_MODULO=$2
DIRETORIO_ORIGINAL=$PWD
VERSAO_MODULO='3.5'

#An  archive becomes a modular JAR when you include a module descriptor, module-info.class, in the root of the given directories or in the root of the .jar archive.
#jar --create --file=lib/net.codetojoy.service@1.0.jar --module-version=1.0 --main-class=net.codetojoy.service.impl.UserService -C build/modules/net.codetojoy.service . 

echo "===========================================================+"
echo "Criando diretório temporário...                            |"
echo "===========================================================+"
mkdir -p ${DIRETORIO_ORIGINAL}/saida

echo "===========================================================+"
echo "salvando o pacote original...                              |"
echo "===========================================================+"
echo "cp ${DIRETORIO_ORIGINAL}/${CAMINHO_PACOTE_JAR} ${DIRETORIO_ORIGINAL}/saida/${NOME_MODULO}-${VERSAO_MODULO}.jar"
cp ${DIRETORIO_ORIGINAL}/${CAMINHO_PACOTE_JAR} ${DIRETORIO_ORIGINAL}/saida/${NOME_MODULO}-${VERSAO_MODULO}.jar

echo "===========================================================+"
echo "recriando temporário diretório de classes extraídas...     |"
echo "===========================================================+"
rm -rf classes_empacotadas
mkdir classes_empacotadas

echo "===========================================================+"
echo "Entrando no temporário diretório de classes extraídas...   |"
echo "===========================================================+"
cd classes_empacotadas

echo "===========================================================+"
echo "salvando o pacote original...                              |"
echo "===========================================================+"
echo "jar --verbose --extract --file=$DIRETORIO_ORIGINAL/$CAMINHO_PACOTE_JAR"
jar --verbose --extract --file=${DIRETORIO_ORIGINAL}/${CAMINHO_PACOTE_JAR}

echo "===========================================================+"
echo "Entrando no diretório...                                  |"
echo "===========================================================+"
echo "$DIRETORIO_ORIGINAL/diretorio_trabalho_temporario/$NOME_MODULO"
cd ${DIRETORIO_ORIGINAL}/diretorio_trabalho_temporario/${NOME_MODULO}

echo "===========================================================+"
echo "salvando o pacote original...                              |"
echo "===========================================================+"
echo "javac -p ${NOME_MODULO} -d ${DIRETORIO_ORIGINAL}/classes_empacotadas module-info.java"
javac -p ${NOME_MODULO} -d ${DIRETORIO_ORIGINAL}/classes_empacotadas module-info.java

echo "===============================================================+"
echo "atualizando aquele pacote salvo com essa classe descritora...  |"
echo "===============================================================+"
echo "jar --verbose --module-version=${VERSAO_MODULO} --update --file=$DIRETORIO_ORIGINAL/saida/$NOME_MODULO.jar -C $DIRETORIO_ORIGINAL/classes_empacotadas module-info.class"
jar --verbose --module-version=${VERSAO_MODULO} --update --file=${DIRETORIO_ORIGINAL}/saida/${NOME_MODULO}-${VERSAO_MODULO}.jar -C ${DIRETORIO_ORIGINAL}/classes_empacotadas module-info.class

cd ${DIRETORIO_ORIGINAL}
echo "Pronto."
