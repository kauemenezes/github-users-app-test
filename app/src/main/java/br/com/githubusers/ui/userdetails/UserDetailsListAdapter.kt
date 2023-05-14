package br.com.githubusers.ui.userdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.domain.model.Repo
import br.com.githubusers.databinding.UserDetailsItemBinding

class UserDetailsListAdapter(private val onClick: (String) -> Unit) : ListAdapter<Repo, UserDetailsListAdapter.ReposViewHolder>(ReposDiffItemCallback()) {
    class ReposViewHolder(val binding: UserDetailsItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
        return ReposViewHolder(
            UserDetailsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        holder.binding.userRepo.text = currentList[position].name
        holder.binding.repoContainer.setOnClickListener {
            onClick(currentList[position].url)
        }
    }
}

class ReposDiffItemCallback : DiffUtil.ItemCallback<Repo>() {
    override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean {
        return oldItem == newItem
    }
}