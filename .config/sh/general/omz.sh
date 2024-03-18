export ZSH="$HOME/.oh-my-zsh"
ZSH_THEME="suvash"
plugins=(
  zsh-autosuggestions
  zsh-syntax-highlighting
)
source $ZSH/oh-my-zsh.sh
export MANPATH="/usr/local/man:$MANPATH"
if [[ -n $SSH_CONNECTION ]]; then
	export EDITOR='vim'
else
	export EDITOR='mvim'
fi
