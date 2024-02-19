local km = vim.keymap -- for conciseness

-- clear search highlights
km.set("n", "<leader>nh", ":nohl<CR>", { desc = "Clear search highlights" })

-- delete single character without copying into register
km.set("n", "x", '"_x')

-- increment/decrement numbers
km.set("n", "<leader>+", "<C-a>", { desc = "Increment number" }) -- increment
km.set("n", "<leader>-", "<C-x>", { desc = "Decrement number" }) -- decrement

-- vscode like keymaps
-- copy line down alt+shift+j
km.set("i", "<M-J>", "<Esc>:t-<CR>==gi")
km.set("n", "<M-J>", "<Esc>:t-<CR>")
km.set("v", "<M-J>", "<Esc>:t-<CR>==gv")
-- mode line up and down with alt+j/k
km.set("i", "<M-j>", "<Esc>:m .+1<CR>==gi")
km.set("i", "<M-k>", "<Esc>:m .-2<CR>==gi")
km.set("n", "<M-j>", "<Esc>:m .+1<CR>")
km.set("n", "<M-k>", "<Esc>:m .-2<CR>")
km.set("v", "<M-j>", ":m '>+1<CR>gv=gv")
km.set("v", "<M-k>", ":m '<-2<CR>gv=gv")
-- delete word left with alt+backspace
km.set("i", "<M-BS>", "<C-w>")
km.set("n", "<M-BS>", "db")
-- delete line alt+shift+l
km.set("i", "<M-L>", "<C-o>dd")
km.set("n", "<M-L>", "dd")

-- quick action
km.set("n", "<Esc>", ":q")
km.set("n", "<C-s>", ":w<CR>")

-- window management
km.set("n", "<leader>sv", "<C-w>v", { desc = "Split window vertically" }) -- split window vertically
km.set("n", "<leader>sh", "<C-w>s", { desc = "Split window horizontally" }) -- split window horizontally
km.set("n", "<leader>se", "<C-w>=", { desc = "Make splits equal size" }) -- make split windows equal width & height
km.set("n", "<leader>sx", "<cmd>close<CR>", { desc = "Close current split" }) -- close current split window

km.set("n", "<leader>to", "<cmd>tabnew<CR>", { desc = "Open new tab" }) -- open new tab
km.set("n", "<leader>tx", "<cmd>tabclose<CR>", { desc = "Close current tab" }) -- close current tab
km.set("n", "<leader>tn", "<cmd>tabn<CR>", { desc = "Go to next tab" }) --  go to next tab
km.set("n", "<leader>tp", "<cmd>tabp<CR>", { desc = "Go to previous tab" }) --  go to previous tab
km.set("n", "<leader>tf", "<cmd>tabnew %<CR>", { desc = "Open current buffer in new tab" }) --  move current buffer to new tab


