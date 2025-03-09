journalctl -xe  # 查看系统日志
dmesg | less    # 查看内核日志
dd if=/dev/zero of=/swapfile bs=1M count=2048 # 开启虚拟内存
# 清理页缓存、目录项和 inode 缓存（不影响运行中的进程）
sudo sync && echo 3 | sudo tee /proc/sys/vm/drop_caches