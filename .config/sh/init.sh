# for FILE in $(find ~/.config/sh/general -name '*.sh'); do
#     source "$FILE"
# done
#
# for FILE in $(find ~/.config/sh/env -name '*.sh'); do
#     source "$FILE"
# done

for FILE in $(find ~/.config/sh -name '*.sh'); do
	if [ $FILE != '/home/abrarshakhi/.config/sh/init.sh' ]; then
		source "$FILE"
	fi
done
