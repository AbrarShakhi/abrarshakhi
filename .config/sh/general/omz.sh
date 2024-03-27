export ZSH="$HOME/.oh-my-zsh"
omz_themes=("half-life" "cloud" "imajes" "terminalparty" "theunraveler" "wedisagree")
ZSH_THEME=${omz_themes[3]}
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
