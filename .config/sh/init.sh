SH_PATH=~/.config/sh

INIT=$(find $SH_PATH -name 'init.sh')

for FILE in $(find $SH_PATH -name '*.sh'); do
	if [ $FILE != $INIT ]; then
		source $FILE
	fi
done
