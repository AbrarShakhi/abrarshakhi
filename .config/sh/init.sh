for FILE in $(find ~/.config/sh/alias.sh -name '*.sh'); do
    source "$FILE"
done

for FILE in $(find ~/.config/sh/env -name '*.sh'); do
    source "$FILE"
done
